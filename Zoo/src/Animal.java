public class Animal {

    private int animalId;
    private String name;
    private String type;
    private String category;
    private int animaldob;
    private int animaldoa;
    private String sex;
    private boolean animalincage;

    public Animal(int animalId, String name, String type, String category,
                  int animaldob, int animaldoa, String sex)
            throws InputValidationException {

        setAnimalId(animalId);
        setName(name);
        setType(type);
        setCategory(category);
        setAnimaldob(animaldob);
        setAnimaldoa(animaldoa);
        setSex(sex);
        setAnimalincage(false);
    }


    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) throws InputValidationException {
        if (animalId > 0 && animalId <= 9999) {
            this.animalId = animalId;
        } else {
            throw new InputValidationException("Animal ID must be between 1 and 9999");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) throws InputValidationException {
        if (name != null && name.matches("(\\p{ASCII}){2,25}")) {
            this.name = name;
        } else {
            throw new InputValidationException("Invalid name");
        }
    }


    public String getType() {
        return type;
    }

    public void setType(String type) throws InputValidationException {
        if (type != null && type.matches("(\\p{ASCII}){2,25}")) {
            this.type = type;
        } else {
            throw new InputValidationException("Invalid type");
        }
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) throws InputValidationException {
        if (category != null && category.matches("Predator|Prey")) {
            this.category = category;
        } else {
            throw new InputValidationException("Category must be Predator or Pray");
        }
    }


    public int getAnimaldob() {
        return animaldob;
    }

    public void setAnimaldob(int animaldob) throws InputValidationException {
        if (String.valueOf(animaldob).matches("\\d{6}")) {
            this.animaldob = animaldob;
        } else {
            throw new InputValidationException("Animal DOB must be 6 digits");
        }
    }


    public int getAnimaldoa() {
        return animaldoa;
    }

    public void setAnimaldoa(int animaldoa) throws InputValidationException {
        if (String.valueOf(animaldoa).matches("\\d{6}")) {
            this.animaldoa = animaldoa;
        } else {
            throw new InputValidationException("Animal DOA must be 6 digits");
        }
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws InputValidationException {
        if (sex != null && sex.matches("male|female")) {
            this.sex = sex;
        } else {
            throw new InputValidationException("Sex must be male or female");
        }
    }


    public boolean isAnimalincage() {
        return animalincage;
    }

    public void setAnimalincage(boolean animalincage) {
        this.animalincage = animalincage;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", animaldob=" + animaldob +
                ", animaldoa=" + animaldoa +
                ", sex='" + sex + '\'' +
                ", animalincage=" + animalincage +
                '}';
    }
}
