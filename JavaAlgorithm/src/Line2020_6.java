import java.util.*;

public class Line2020_6 {

    static TreeMap<String, Company> companyMap = new TreeMap<>();
    static List<Applicant> applicantList = new ArrayList<>();

    public static void main(String[] args) {
        String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
        String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
        solution(companies, applicants);
    }

    public static String[] solution(String[] companies, String[] applicants) {
        String[] answer = {};

        for (String strCompanyInfo : companies) {
            String[] split = strCompanyInfo.split(" ");
            Company company = new Company(split[1], Integer.valueOf(split[2]));
            companyMap.put(split[0], company);
        }

        for (String strApplicantInfo : applicants) {
            String[] split = strApplicantInfo.split(" ");
            Applicant applicant = new Applicant(split[0], split[1], Integer.valueOf(split[2]));
            applicantList.add(applicant);
        }


        List<Applicant> rejectedList = applicantList;
        while (rejectedList == null || rejectedList.size() > 0) {
            for (Applicant applicant : rejectedList) {
                String companyName = applicant.getFirstCompany();
                Company company = companyMap.get(companyName);
                company.application(applicant);
            }

            rejectedList = new ArrayList<>();

            List<Applicant> finalRejectedList = rejectedList;

            companyMap.forEach((key, value) -> {
                List<Applicant> rejectingList = value.choiceApplicant();
                for (Applicant applicant : rejectingList) {
                    finalRejectedList.add(applicant);
                }
            });

        }


        return answer;
    }

    static class Company {
        String priority;
        List<Applicant> applicantList = new ArrayList<>();
        List<Applicant> choiceApplicantList = new ArrayList<>();
        List<Applicant> rejected = new ArrayList<>();
        int recruitCount;

        public Company(String priority, int recruitCount) {
            this.priority = priority;
            this.recruitCount = recruitCount;
        }

        public void application(Applicant applicant) {
            applicantList.add(applicant);
            applicant.application();
        }

        public List<Applicant> choiceApplicant() {
            String[] strPriority = priority.split("");
            for (String priority : strPriority){
                for (Applicant applicant : applicantList) {
                    if (priority.equals(applicant.name)) {
                        choiceApplicantList.add(applicant);
                    }
                }
            }

            for (Applicant applicant : choiceApplicantList) {
                applicantList.remove(applicant);
            }

            rejected = applicantList;
            applicantList = choiceApplicantList;
            return rejected;
        }

    }

    static class Applicant {
        String name;
        String hopeCompany;
        int hopeCompanyCount;

        public void application() {
            hopeCompany = hopeCompany.substring(1);
            hopeCompanyCount--;
        }

        public String getFirstCompany() {
            return String.valueOf(hopeCompany.charAt(0));
        }

        public Applicant(String name, String hopeCompany, int hopeCompanyCount) {
            this.name = name;
            this.hopeCompany = hopeCompany;
            this.hopeCompanyCount = hopeCompanyCount;
        }
    }

}
