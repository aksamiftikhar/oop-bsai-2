public class Polymorphism {

    String commissionEmployee;
    String socialSecurityNumber;
    double grossSales;
    double commissionRates;
    public Polymorphism( String commissionEmployee,String socialSecurityNumber,double grossSales,double commissionRates){
        this.commissionEmployee=commissionEmployee;
        this.socialSecurityNumber=socialSecurityNumber;
        this.grossSales=grossSales;
        this.commissionRates=commissionRates;


    }
    public void setCommissionEmployee(String commissionEmployee){
        this.commissionEmployee=commissionEmployee;
    }
    public String getCommissionEmployee(){
        return commissionEmployee;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber){
        this.socialSecurityNumber=socialSecurityNumber;
    }
    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }
    public void setGrossSales(double grossSales){
        this.grossSales=grossSales;
    }
    public double getGrossSales(){
        return grossSales;
    }

    public void setCommissionRates(double commissionRates){
        this.commissionRates=commissionRates;
    }
    public double getCommissionRates(){
        return commissionRates;
    }
    public static void main(String[] args) {
        CommissionEmployee c=new CommissionEmployee("Sue Jhons", "222-222-222", 10000.0, 0.06);
        BasePlusCommissionEmployee1 b=new BasePlusCommissionEmployee1("Bob lewis", "333-333-333", 5000.0, 0.04, 300.00);
        System.out.println  (c.toString());
        System.out.println(b.toString());
        Polymorphism p=(Polymorphism)b;
        System.out.println(p.toString());


    }

}
class CommissionEmployee extends Polymorphism{

    public CommissionEmployee( String commissionEmployee,String socialSecurityNumber,double grossSales,double commissionRates){
        super(commissionEmployee, socialSecurityNumber, grossSales, commissionRates);
        System.out.println(toString());
    }
    @Override
    public String toString(){
        return String.format("%s:%s %s:%s\n%s: %.2f\n%s: %.2f\n%s: %.2f ",
                "commision employee:",commissionEmployee,
                "socialSecurityNumber:",socialSecurityNumber,
                "grossSales:",grossSales,
                "commisionRates:",commissionRates);


    }

}
class BasePlusCommissionEmployee1 extends Polymorphism{
    double baseSalary;
    public BasePlusCommissionEmployee1(String commissionEmployee,String socialSecurityNumber,double grossSales,double commissionRates,double baseSalary){
        super(commissionEmployee, socialSecurityNumber, grossSales, commissionRates);
        this.baseSalary=baseSalary;

    }
    public void setBaseSalary(double baseSalary){
        this.baseSalary=baseSalary;
    }
    public double getBaseSalary(){
        return baseSalary;
    }
    @Override
    public String toString(){
        return String.format("%s:%s %s:%s\n%s: %.2f\n%s: %.2f\n%s: %.2f ",
                "commision employee:",commissionEmployee,
                "socialSecurityNumber:",socialSecurityNumber,
                "grossSales:",grossSales,
                "commisionRates:",commissionRates ,
                "baseSalary:",baseSalary);

    }

}
