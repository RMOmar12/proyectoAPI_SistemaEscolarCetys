package com.plataformasHeterogeneas.proyectoAPI.service;

import com.plataformasHeterogeneas.proyectoAPI.model.Grade;
import com.plataformasHeterogeneas.proyectoAPI.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public void calculateAndSaveFinalScore(Long studentId, Long courseId) {
        // Retrieve quarter scores for the student and course
        List<Grade> quarterGrades = gradeRepository.findByStudentIDAndCourseID(studentId, courseId);

        // Calculate the final score
        OptionalDouble finalScore = quarterGrades.stream()
                .mapToInt(Grade::getScore)
                .average();

        // Update or save the final score in the database
        if (finalScore.isPresent()) {
            double finalScoreValue = finalScore.getAsDouble();

            // Check if a final score record already exists
            Grade finalScoreRecord = gradeRepository.findByStudentIDAndCourseIDAndQuarter(studentId, courseId, 4);
            if (finalScoreRecord != null) {
                // Update existing final score
                finalScoreRecord.setScore((int) finalScoreValue);
                gradeRepository.save(finalScoreRecord);
            } else {
                // Create a new final score record
                Grade newFinalScore = new Grade();
                newFinalScore.setStudentID(studentId);
                newFinalScore.setCourseID(courseId);
                newFinalScore.setQuarter(4); // Q4 is the final score
                newFinalScore.setScore((int) finalScoreValue);
                gradeRepository.save(newFinalScore);
            }
        }
    }
}
