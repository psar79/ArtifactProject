package ArtifactProject.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "LetterGeneral")
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Sender sender;

    @OneToOne
    @JoinColumn(name = "senderAddress_id", referencedColumnName = "id")
    private SenderAddress senderAddress;

    @OneToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "id")
    private Receiver receiver;

    @OneToOne
    @JoinColumn(name = "receiverAddress_id", referencedColumnName = "id")
    private ReceiverAddress receiverAddress;

    @OneToOne
    @JoinColumn(name = "information_id", referencedColumnName = "id")
    private Information information;

    public Letter() {
    }

    public Long getId() {
        return id;
    }

    public Letter setId(Long id) {
        this.id = id;
        return this;
    }

    public Sender getSender() {
        return sender;
    }

    public Letter setSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    public SenderAddress getSenderAddress() {
        return senderAddress;
    }

    public Letter setSenderAddress(SenderAddress senderAddress) {
        this.senderAddress = senderAddress;
        return this;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Letter setReceiver(Receiver receiver) {
        this.receiver = receiver;
        return this;
    }

    public ReceiverAddress getReceiverAddress() {
        return receiverAddress;
    }

    public Letter setReceiverAddress(ReceiverAddress receiverAddress) {
        this.receiverAddress = receiverAddress;
        return this;
    }

    public Information getInformation() {
        return information;
    }

    public Letter setInformation(Information information) {
        this.information = information;
        return this;
    }
}
