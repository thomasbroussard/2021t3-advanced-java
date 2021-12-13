package fr.epita.quiz.services.data.impl;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.services.data.api.IMCQQuestionDAO;

@Repository
public class MCQChoiceJPADAO extends GenericJPADAO<MCQChoice> implements IMCQQuestionDAO {


}
