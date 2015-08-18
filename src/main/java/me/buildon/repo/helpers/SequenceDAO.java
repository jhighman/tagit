package me.buildon.repo.helpers;

import me.buildon.domain.SequenceId;

public interface SequenceDAO {
	long getNextSequenceId(String key) throws SequenceException;
	SequenceId registerSequenceId(String key);
}
