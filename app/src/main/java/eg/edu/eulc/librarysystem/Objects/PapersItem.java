package eg.edu.eulc.librarysystem.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eslam El-Meniawy on 30-Dec-15.
 */
public class PapersItem implements Parcelable {
    public static final Parcelable.Creator<PapersItem> CREATOR = new Parcelable.Creator<PapersItem>() {
        @Override
        public PapersItem createFromParcel(Parcel source) {
            return new PapersItem(source);
        }

        @Override
        public PapersItem[] newArray(int size) {
            return new PapersItem[size];
        }
    };
    private String id, title, authors, volume, pages, publishedIn, publishedAt, serialName, abstractText;

    public PapersItem() {
    }

    public PapersItem(String id, String title, String authors, String volume, String pages, String publishedIn, String publishedAt, String serialName, String abstractText) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.volume = volume;
        this.pages = pages;
        this.publishedIn = publishedIn;
        this.publishedAt = publishedAt;
        this.serialName = serialName;
        this.abstractText = abstractText;
    }

    public PapersItem(Parcel parcel) {
        id = parcel.readString();
        title = parcel.readString();
        authors = parcel.readString();
        volume = parcel.readString();
        pages = parcel.readString();
        publishedIn = parcel.readString();
        publishedAt = parcel.readString();
        serialName = parcel.readString();
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublishedIn() {
        return publishedIn;
    }

    public void setPublishedIn(String publishedIn) {
        this.publishedIn = publishedIn;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
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
        dest.writeString(authors);
        dest.writeString(volume);
        dest.writeString(pages);
        dest.writeString(publishedIn);
        dest.writeString(publishedAt);
        dest.writeString(serialName);
        dest.writeString(abstractText);
    }
}
