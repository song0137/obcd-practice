package odbc_practice.odbe_practice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import java.util.Date;
import javax.persistence.Temporal;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@Table(name = "covid_data")
public class CovidData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "covid_data_seq")
    @SequenceGenerator(name = "covid_data_seq", sequenceName = "covid_data_seq", allocationSize = 1)
    private int id;

    private String isoCode;
    private String continent;
    private String location;
    @Temporal(TemporalType.DATE)
    private Date reportDate;  // 修改为 Date 类型
    private Double totalCases;
    private Double newCases;
    private Double totalDeaths;
    private Double newDeaths;
    private Double totalCasesPerMillion;
    private Double newCasesPerMillion;
    private Double totalDeathsPerMillion;
    private Double newDeathsPerMillion;
    private Double reproductionRate;
    private Double icuPatients;
    private Double icuPatientsPerMillion;
    private Double hospPatients;
    private Double hospPatientsPerMillion;
    private Double weeklyIcuAdmissions;
    private Double weeklyIcuAdmissionsPerMillion;
    private Double weeklyHospAdmissions;
    private Double weeklyHospAdmissionsPerMillion;
    private Double newTests;
    private Double totalTests;
    private Double totalTestsPerThousand;
    private Double newTestsPerThousand;
    private Double positiveRate;
    private Double testsPerCase;
    private String testsUnits;
    private Double totalVaccinations;
    private Double peopleVaccinated;
    private Double peopleFullyVaccinated;
    private Double newVaccinations;
    private Double stringencyIndex;
    private Double population;
    private Double populationDensity;
    private Double medianAge;
    private Double aged65Older;
    private Double aged70Older;
    private Double gdpPerCapita;
    private Double extremePoverty;
    private Double cardiovascDeathRate;
    private Double diabetesPrevalence;
    private Double femaleSmokers;
    private Double maleSmokers;
    private Double handwashingFacilities;
    private Double hospitalBedsPerThousand;
    private Double lifeExpectancy;
    private Double humanDevelopmentIndex;
}
