import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity()
@Table(name = "PurchaseList")
public class PurchaseList implements Serializable {

    @EmbeddedId
    private PurchaseListPK id;

    @Basic
    @Column(name = "price")
    private int price;

    @Basic
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public PurchaseList(PurchaseListPK id, int price, Date subscriptionDate) {
        this.id = id;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }

    public PurchaseList() {
    }

    public PurchaseListPK getId() {
        return id;
    }

    public void setId(PurchaseListPK id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
