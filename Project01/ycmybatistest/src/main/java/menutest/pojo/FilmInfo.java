package menutest.pojo;


/**
 * @author LX
 * @date 2019/3/3 - 14:52
 */
public class FilmInfo {

    private Integer filmID;
    private Integer typeID;
    private String filmName;
    private String actor;
    private String director;
    private String ticketPrice;

    @Override
    public String toString() {
        return "FilmInfo{" +
                "filmID=" + filmID +
                ", typeID=" + typeID +
                ", filmName='" + filmName + '\'' +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", filmType=" + filmType +
                '}';
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

    private FilmType filmType;

}
