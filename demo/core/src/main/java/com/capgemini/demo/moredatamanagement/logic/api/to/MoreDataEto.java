package com.capgemini.demo.moredatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.moredatamanagement.common.api.MoreData;

/**
 * Entity transport object of MoreData
 */
public class MoreDataEto extends AbstractEto implements MoreData {

	private static final long serialVersionUID = 1L;
	private String example;
	private Long sampleDataId;

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	@Override
	public void setSampleDataId(Long sampleDataId) {
		this.sampleDataId = sampleDataId;
	}

	@Override
	public Long getSampleDataId() {
		return this.sampleDataId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.example == null) ? 0 : this.example.hashCode());
		result = prime * result + ((this.sampleDataId == null) ? 0 : this.sampleDataId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// class check will be done by super type EntityTo!
		if (!super.equals(obj)) {
			return false;
		}
		MoreDataEto other = (MoreDataEto) obj;
		if (this.example == null) {
			if (other.example != null) {
				return false;
			}
		} else if (!this.example.equals(other.example)) {
			return false;
		}
		if (this.sampleDataId == null) {
			if (other.sampleDataId != null) {
				return false;
			}
		} else if (!this.sampleDataId.equals(other.sampleDataId)) {
			return false;
		}
		return true;
	}
}
