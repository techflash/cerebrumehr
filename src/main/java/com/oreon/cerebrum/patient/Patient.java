/**
 * This file is generated by Witchcraftmda.
 * DO NOT MODIFY any changes will be overwritten with the next run of the code generator.
 *
 */

package com.oreon.cerebrum.patient;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.NGramFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.Formula;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

import com.oreon.cerebrum.facility.Bed;

@Entity
@Table(name = "patient")
@Filters( { @Filter(name = "archiveFilterDef"),
		@Filter(name = "tenantFilterDef") })
@Cache(usage = CacheConcurrencyStrategy.NONE)
@XmlRootElement
@Indexed
@AnalyzerDef(name = "ngrams", tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class), filters = {
		@TokenFilterDef(factory = LowerCaseFilterFactory.class),
		@TokenFilterDef(factory = NGramFilterFactory.class, params = {
				@Parameter(name = "minGramSize", value = "3"),
				@Parameter(name = "maxGramSize", value = "4") }) })
public class Patient extends PatientBase implements java.io.Serializable {
	private static final long serialVersionUID = -586507236L;

	@Override
	@Fields( {
			@Field(index = Index.YES),
			@Field(index = Index.YES, name = "firstName:ngrams", analyzer = @Analyzer(definition = "ngrams")) })
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}

	@Override
	@Fields( {
			@Field(index = Index.YES),
			@Field(index = Index.YES, name = "lastName:ngrams", analyzer = @Analyzer(definition = "ngrams")) })
	public String getLastName() {
		// TODO Auto-generated method stubR
		return super.getLastName();
	}

	@Override
	// @Analyzer(definition = "entityAnalyzer")
	@IndexedEmbedded
	public ContactDetails getContactDetails() {
		// TODO Auto-generated method stub
		return super.getContactDetails();
	}
	
	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		String ret = String.format("%s %s %s ", title , firstName , lastName );
		ret = ret.replaceAll("null|0", "");
		return ret;
	}
	
	
	public String getDetailedInfo() {
		// TODO Auto-generated method stub
		String ret = String.format("%s %s %s %s %s", title , firstName , lastName , getGender() , getAge());
		ret = ret.replaceAll("null|0", "");
		return ret;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDisplayName();
	}
	
	
	@Formula(value = "(FLOOR(DATEDIFF( NOW(), dateOfBirth) / 3652.5))")
	protected Integer ageInterval;

	public Integer getAgeInterval() {
		return ageInterval;
	}

	public void setAgeInterval(Integer ageInterval) {
		this.ageInterval = ageInterval;
	} 
	
	@Transient
	private Bed bed;

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}
	
	
}
