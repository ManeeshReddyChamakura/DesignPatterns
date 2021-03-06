package com.creationalpatterns.builder;

/**
 * Below is taken exactly from https://www.geeksforgeeks.org/builder-design-pattern/
 * `Separate the construction of a complex object from its representation so that the same construction process can create different representations`
 */

/**
 * Abstract interface for the product
 * Here in this example product is House
 */
interface HousePlan
{
    public void setBasement(String basement);

    public void setStructure(String structure);

    public void setRoof(String roof);

    public void setInterior(String interior);
}

/**
 * Class for which object is to be generated by builder pattern
 *
 */
class House implements HousePlan
{

    private String basement;
    private String structure;
    private String roof;
    private String interior;

    public void setBasement(String basement)
    {
        this.basement = basement;
    }

    public void setStructure(String structure)
    {
        this.structure = structure;
    }

    public void setRoof(String roof)
    {
        this.roof = roof;
    }

    public void setInterior(String interior)
    {
        this.interior = interior;
    }

}

/**
 * Builder interface defines the common methods for all the concrete builders
 * We can also use a abstract class here as we can see in the below three concrete builders house field is added
 */
interface HouseBuilder
{

    public void buildBasement();

    public void buildStructure();

    public void buildRoof();

    public void buildInterior();

    public House getHouse();
}

/*
    abstract class HouseBuilder {
        private House house;
        public HouseBuilder() {
            house = new House();
        }
        public void buildBasement(String s) {
            house.setBasement(s);
        }
        public void buildStructure(String s) {
            house.setBasement(s);
        }
        ...
    }
 */


/**
 * Concrete house builder class
 * which contains the methods for various steps of the object creation
 */
class IglooHouseBuilder implements HouseBuilder
{
    private House house;

    public IglooHouseBuilder()
    {
        this.house = new House();
    }

    public void buildBasement()
    {
        house.setBasement("Ice Bars");
    }

    public void buildStructure()
    {
        house.setStructure("Ice Blocks");
    }

    public void buildInterior()
    {
        house.setInterior("Ice Carvings");
    }

    public void buildRoof()
    {
        house.setRoof("Ice Dome");
    }

    public House getHouse()
    {
        return this.house;
    }
}

class TipiHouseBuilder implements HouseBuilder
{
    private House house;

    public TipiHouseBuilder()
    {
        this.house = new House();
    }

    public void buildBasement()
    {
        house.setBasement("Wooden Poles");
    }

    public void buildStructure()
    {
        house.setStructure("Wood and Ice");
    }

    public void buildInterior()
    {
        house.setInterior("Fire Wood");
    }

    public void buildRoof()
    {
        house.setRoof("Wood, caribou and seal skins");
    }

    public House getHouse()
    {
        return this.house;
    }

}

/**
 * Director class which has a HouseBuilder reference and
 * has construct method which includes the algorithm or the step by step process of creating our complex object(House in this case)
 * In reality, each step in the process can also include creation of many other objects
 */
class CivilEngineer
{

    private HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder)
    {
        this.houseBuilder = houseBuilder;
    }

    public House getHouse()
    {
        return this.houseBuilder.getHouse();
    }

    public void constructHouse()
    {
        this.houseBuilder.buildBasement();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildInterior();
    }
}

class Builder
{
    public static void main(String[] args)
    {
        HouseBuilder iglooBuilder = new IglooHouseBuilder();
        CivilEngineer engineer = new CivilEngineer(iglooBuilder);

        engineer.constructHouse();

        House house = engineer.getHouse();

        System.out.println("Builder constructed: "+ house);
    }
}

