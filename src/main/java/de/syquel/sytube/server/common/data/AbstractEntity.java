package de.syquel.sytube.server.common.data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@Access(AccessType.FIELD)
public class AbstractEntity<ID extends Serializable> implements Serializable {

	@Id
	@GeneratedValue
	@Access(AccessType.PROPERTY)
	private ID id;

	@Version
	private Long version;

	protected AbstractEntity() {
		// Default JPA constructor
	}

	public ID getId() {
		return id;
	}

	protected void setId(final ID id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(final Long version) {
		this.version = version;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final AbstractEntity<?> that)) {
			return false;
		}

		return id != null && id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
