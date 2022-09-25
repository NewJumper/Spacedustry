package com.newjumper.spacedustry.capabilities;

public enum GasTypes {
    HYDROGEN("hydrogen", "H2"),
    NITROGEN("nitrogen", "N2"),
    OXYGEN("oxygen", "O2"),
    METHANE("methane", "CH4");

    private final String name;
    private final String formula;

    GasTypes(String name, String formula) {
        this.name = name;
        this.formula = formula;
    }

    public String getName() {
        return name;
    }

    public String getFormula() {
        return formula;
    }
}
