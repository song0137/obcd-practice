package odbc_practice.odbe_practice;

import com.opencsv.CSVReader;

import odbc_practice.odbe_practice.entities.CovidData;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileReader;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CovidData.class)
                .buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/owid-covid-data.csv"));
            String[] lineText;
            csvReader.readNext(); // Skip header line

            while ((lineText = csvReader.readNext()) != null) {
                CovidData covidData = new CovidData();
                covidData.setIsoCode(lineText[0]);
                covidData.setContinent(lineText[1]);
                covidData.setLocation(lineText[2]);
                covidData.setDate(lineText[3]);
                covidData.setTotalCases(parseDoubleOrZero(lineText[4]));
                covidData.setNewCases(parseDoubleOrZero(lineText[5]));
                covidData.setTotalDeaths(parseDoubleOrZero(lineText[6]));
                covidData.setNewDeaths(parseDoubleOrZero(lineText[7]));
                covidData.setTotalCasesPerMillion(parseDoubleOrZero(lineText[8]));
                covidData.setNewCasesPerMillion(parseDoubleOrZero(lineText[9]));
                covidData.setTotalDeathsPerMillion(parseDoubleOrZero(lineText[10]));
                covidData.setNewDeathsPerMillion(parseDoubleOrZero(lineText[11]));
                covidData.setReproductionRate(parseDoubleOrZero(lineText[12]));
                covidData.setIcuPatients(parseDoubleOrZero(lineText[13]));
                covidData.setIcuPatientsPerMillion(parseDoubleOrZero(lineText[14]));
                covidData.setHospPatients(parseDoubleOrZero(lineText[15]));
                covidData.setHospPatientsPerMillion(parseDoubleOrZero(lineText[16]));
                covidData.setWeeklyIcuAdmissions(parseDoubleOrZero(lineText[17]));
                covidData.setWeeklyIcuAdmissionsPerMillion(parseDoubleOrZero(lineText[18]));
                covidData.setWeeklyHospAdmissions(parseDoubleOrZero(lineText[19]));
                covidData.setWeeklyHospAdmissionsPerMillion(parseDoubleOrZero(lineText[20]));
                covidData.setNewTests(parseDoubleOrZero(lineText[21]));
                covidData.setTotalTests(parseDoubleOrZero(lineText[22]));
                covidData.setTotalTestsPerThousand(parseDoubleOrZero(lineText[23]));
                covidData.setNewTestsPerThousand(parseDoubleOrZero(lineText[24]));
                covidData.setPositiveRate(parseDoubleOrZero(lineText[25]));
                covidData.setTestsPerCase(parseDoubleOrZero(lineText[26]));
                covidData.setTestsUnits(lineText[27]);
                covidData.setTotalVaccinations(parseDoubleOrZero(lineText[28]));
                covidData.setPeopleVaccinated(parseDoubleOrZero(lineText[29]));
                covidData.setPeopleFullyVaccinated(parseDoubleOrZero(lineText[30]));
                covidData.setNewVaccinations(parseDoubleOrZero(lineText[31]));
                covidData.setStringencyIndex(parseDoubleOrZero(lineText[32]));
                covidData.setPopulation(parseDoubleOrZero(lineText[33]));
                covidData.setPopulationDensity(parseDoubleOrZero(lineText[34]));
                covidData.setMedianAge(parseDoubleOrZero(lineText[35]));
                covidData.setAged65Older(parseDoubleOrZero(lineText[36]));
                covidData.setAged70Older(parseDoubleOrZero(lineText[37]));
                covidData.setGdpPerCapita(parseDoubleOrZero(lineText[38]));
                covidData.setExtremePoverty(parseDoubleOrZero(lineText[39]));
                covidData.setCardiovascDeathRate(parseDoubleOrZero(lineText[40]));
                covidData.setDiabetesPrevalence(parseDoubleOrZero(lineText[41]));
                covidData.setFemaleSmokers(parseDoubleOrZero(lineText[42]));
                covidData.setMaleSmokers(parseDoubleOrZero(lineText[43]));
                covidData.setHandwashingFacilities(parseDoubleOrZero(lineText[44]));
                covidData.setHospitalBedsPerThousand(parseDoubleOrZero(lineText[45]));
                covidData.setLifeExpectancy(parseDoubleOrZero(lineText[46]));
                covidData.setHumanDevelopmentIndex(parseDoubleOrZero(lineText[47]));

                session.save(covidData);
            }

            csvReader.close();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
    
    private static Double parseDoubleOrZero(String value) {
        try {
            return value == null || value.isEmpty() ? 0.0 : Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
