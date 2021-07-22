package de.syquel.sytube.server.common.data;

import org.bson.types.ObjectId;

import java.util.Objects;

public class AbstractEntity {

	private ObjectId id;

	protected AbstractEntity() {
		// Default JPA constructor
	}

	public ObjectId getId() {
		return id;
	}

	protected void setId(final ObjectId id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final AbstractEntity that)) {
			return false;
		}

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
