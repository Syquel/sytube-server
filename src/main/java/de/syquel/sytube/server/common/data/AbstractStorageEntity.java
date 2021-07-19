package de.syquel.sytube.server.common.data;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public class AbstractStorageEntity extends AbstractEntity<UUID> {

	@Basic
	@NotBlank
	private String blobName;

	public String getBlobName() {
		return blobName;
	}

	public void setBlobName(final String blobName) {
		this.blobName = blobName;
	}

}
