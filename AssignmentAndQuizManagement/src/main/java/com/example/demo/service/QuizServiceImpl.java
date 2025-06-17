package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.dto.Course;
import com.example.demo.dto.QuizResponseDTO;
import com.example.demo.feignclient.CourseClient;
import com.example.demo.feignclient.UserClient;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizSubmission;
import com.example.demo.repository.QuizRepository;
import com.example.demo.repository.QuizSubmissionRepository;

@Service
public class QuizServiceImpl implements QuizService {

    private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);

    @Autowired
    QuizRepository repository;

    @Autowired
    CourseClient courseClient;

    @Autowired
    UserClient userClient;

    @Autowired
    QuizSubmissionRepository submissionrepository;

    @Override
    public String saveQuiz(Quiz quiz) {
        logger.info("Saving quiz for courseId: {}", quiz.getCourseId());
        if (!courseClient.existsById(quiz.getCourseId())) {
            logger.warn("Invalid courseId: {}", quiz.getCourseId());
            return "Invalid courseId";
        } else {
            repository.save(quiz);
            logger.info("Quiz saved successfully.");
            return "Quiz added successfully.";
        }
    }

    @Override
    public String deleteQuizById(int quizId) {
        logger.info("Deleting quiz with ID: {}", quizId);
        repository.deleteById(quizId);
        return "Quiz deleted successfully.....";
    }

    @Override
    public QuizResponseDTO getQuizByid(int quizId) {
        logger.info("Fetching quiz with ID: {}", quizId);
        Quiz quiz = repository.findById(quizId).get();
        int courseId = quiz.getCourseId();
        Course course = courseClient.getcourse(courseId);
        return new QuizResponseDTO(course, quiz);
    }

    @Override
    public String updateQuiz(Quiz quiz) {
        logger.info("Updating quiz with ID: {}", quiz.getQuizId());
        repository.save(quiz);
        return "quiz updated successfully";
    }

    @Override
    public QuizSubmission evaluateQuiz(QuizSubmission quizSubmission) {
        logger.info("Evaluating quiz submission for userId: {}, quizId: {}", quizSubmission.getUserId(), quizSubmission.getQuizId());

        QuizSubmission existingSubmission = submissionrepository.findByUserIdAndQuizId(
                quizSubmission.getUserId(), quizSubmission.getQuizId());

        if (existingSubmission != null) {
            logger.warn("Duplicate submission detected for userId: {}, quizId: {}", quizSubmission.getUserId(), quizSubmission.getQuizId());
            throw new IllegalStateException("Quiz has already been submitted by this user.");
        }

        Quiz quiz = repository.findById(quizSubmission.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        int score = 0;
        List<String> correctAnswers = quiz.getCorrectAnswer();
        List<String> responses = quizSubmission.getResponses();

        for (int i = 0; i < responses.size(); i++) {
            String response = responses.get(i);
            String correctAnswer = correctAnswers.get(i);
            if (response != null && response.equalsIgnoreCase(correctAnswer)) {
                score += 1;
            }
        }

        quizSubmission.setScore(score);
        quizSubmission.setPassed(score >= quiz.getTotalMarks() * 0.5);
        submissionrepository.save(quizSubmission);

        logger.info("Quiz evaluated. Score: {}, Passed: {}", score, quizSubmission.isPassed());
        return quizSubmission;
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        logger.info("Fetching all quizzes.");
        return repository.findAll();
    }

    @Override
    public List<Quiz> getQuizByCourseId(int courseId) {
        logger.info("Fetching quizzes for courseId: {}", courseId);
        return repository.findByCourseId(courseId);
    }

    @Override
    public List<QuizSubmission> getAllQuizSubmissionByUserId(int userId) {
        logger.info("Fetching all quiz submissions for userId: {}", userId);
        return submissionrepository.findByUserId(userId);
    }

    @Override
    public QuizSubmission getQuizSubmissionByUserId(int userId, int quizId) {
        logger.info("Fetching quiz submission for userId: {}, quizId: {}", userId, quizId);
        return submissionrepository.findByUserIdAndQuizId(userId, quizId);
    }
}
