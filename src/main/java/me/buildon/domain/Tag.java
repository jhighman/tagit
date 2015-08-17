package me.buildon.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tag {

	public Tag(String tag) {
		super();
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Tag [tag=" + tag + "]";
	}

	private String tag;

	public String getTag() {
		return tag;
	}

	public void settag(String tag) {
		this.tag = tag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	
	
}
