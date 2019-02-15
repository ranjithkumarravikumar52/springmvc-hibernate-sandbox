package aopdemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
public class Membership {
    private int id;
    private String membershipType;
    private Date expiryDate;
}
