package bh.edu.ku.futurelibrary.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class DraftThesesItem implements Parcelable {
    public static final Creator<DraftThesesItem> CREATOR = new Creator<DraftThesesItem>() {
        @Override
        public DraftThesesItem createFromParcel(Parcel source) {
            return new DraftThesesItem(source);
        }

        @Override
        public DraftThesesItem[] newArray(int size) {
            return new DraftThesesItem[size];
        }
    };
    private String id, title, year, description, author, details, abstractText;

    public DraftThesesItem() {
    }

    public DraftThesesItem(String id, String title, String year, String description, String author, String details, String abstractText) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
        this.author = author;
        this.details = details;
        this.abstractText = abstractText;
    }

    public DraftThesesItem(Parcel parcel) {
        id = parcel.readString();
        title = parcel.readString();
        year = parcel.readString();
        description = parcel.readString();
        author = parcel.readString();
        details = parcel.readString();
        abstractText = parcel.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(description);
        dest.writeString(author);
        dest.writeString(details);
        dest.writeString(abstractText);
    }
}
