package menutest.pojo;

/**
 * @author LX
 * @date 2019/3/3 - 14:54
 */
public class FilmType {
    private Integer typeID;
    private String typeName;

    @Override
    public String toString() {
        return "FilmType{" +
                "typeID=" + typeID +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
