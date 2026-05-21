package model;

public enum Category 
{
    FOOD("FOOD", 2.5)
    {
        @Override
        public  String getDetails()
        {
            return "this is food the tax rate is 2.5 because it is a nessicity for people \n";
        }

    },
    ELECTRONICS("ELECTRONICS", 20)
    {
        @Override 
        public  String getDetails()
        {
            return "this is Electrinic the tax rate is 20 because it is mostly imported from abroad\n";
        }

    },
    TOOLS("TOOLS", 12.5)
    {
        @Override 
        public  String getDetails()
        {
            return "those are tools, the taxes are just normal\n";
        }

    };

    private String displayName;
    private double taxRate;

    Category(String _displayName, double _taxRate)
    {
        this.displayName = _displayName;
        this.taxRate = _taxRate;
    }


    public String getDisplayName() {
        return displayName;
    }

    public abstract String getDetails();
    public double getTaxRate() {
        return taxRate;
    }
}
