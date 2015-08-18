package me.buildon.repo;

public interface SequenceDAO {

	
	long getNextSequenceId(String key) throws SequenceException;
}
