package bh.edu.ku.futurelibrary.Objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eslam on 26-Nov-15.
 */
public class ResultsStartItem implements Parcelable {
    private long id;
    private String title, image, type, classification, publisher, moreTitle, details, holdings, services;

    public ResultsStartItem() {
    }

    public ResultsStartItem(long id, String title, String image, String type, String classification, String publisher, String moreTitle, String details, String holdings, String services) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.type = type;
        this.classification = classification;
        this.publisher = publisher;
        this.moreTitle = moreTitle;
        this.details = details;
        this.holdings = holdings;
        this.services = services;
    }

    public ResultsStartItem(Parcel parcel) {
        id = parcel.readLong();
        title = parcel.readString();
        image = parcel.readString();
        type = parcel.readString();
        classification = parcel.readString();
        publisher = parcel.readString();
        moreTitle = parcel.readString();
        details = parcel.readString();
        holdings = parcel.readString();
        services = parcel.readString();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public String getClassification() {
        return classification;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getMoreTitle() {
        return moreTitle;
    }

    public String getDetails() {
        return details;
    }

    public String getHoldings() {
        return holdings;
    }

    public String getServices() {
        return services;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setMoreTitle(String moreTitle) {
        this.moreTitle = moreTitle;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setHoldings(String holdings) {
        this.holdings = holdings;
    }

    public void setServices(String services) {
        this.services = services;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(type);
        dest.writeString(classification);
        dest.writeString(publisher);
        dest.writeString(moreTitle);
        dest.writeString(details);
        dest.writeString(holdings);
        dest.writeString(services);
    }

    public static final Creator<ResultsStartItem> CREATOR = new Creator<ResultsStartItem>() {
        @Override
        public ResultsStartItem createFromParcel(Parcel source) {
            return new ResultsStartItem(source);
        }

        @Override
        public ResultsStartItem[] newArray(int size) {
            return new ResultsStartItem[size];
        }
    };
}
