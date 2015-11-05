package eg.edu.eulc.librarysystem;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eslam El-Meniawy on 05-Nov-15.
 */
public class SiteNewsItem implements Parcelable {
    private long id;
    private String title;

    public SiteNewsItem() {
    }

    public SiteNewsItem(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public SiteNewsItem(Parcel parcel) {
        id = parcel.readLong();
        title = parcel.readString();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
    }

    public static final Parcelable.Creator<SiteNewsItem> CREATOR = new Creator<SiteNewsItem>() {
        @Override
        public SiteNewsItem createFromParcel(Parcel source) {
            return new SiteNewsItem(source);
        }

        @Override
        public SiteNewsItem[] newArray(int size) {
            return new SiteNewsItem[size];
        }
    };
}
