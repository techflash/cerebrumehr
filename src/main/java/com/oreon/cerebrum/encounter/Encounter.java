
/**
 * This file is generated by Witchcraftmda.
 * DO NOT MODIFY any changes will be overwritten with the next run of the code generator.
 *
 */

package com.oreon.cerebrum.encounter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;

import com.oreon.cerebrum.ProjectUtils;

@Entity
@Table(name = "encounter")
@Filters({@Filter(name = "archiveFilterDef"), @Filter(name = "tenantFilterDef")})
@Cache(usage = CacheConcurrencyStrategy.NONE)
@XmlRootElement
public class Encounter extends EncounterBase implements java.io.Serializable {
	private static final long serialVersionUID = -1171400456L;
	
	public String getTests() {

		try {
			return ProjectUtils.getTests(this);
		} catch (Exception e) {

			return "";

		}

	}
}
