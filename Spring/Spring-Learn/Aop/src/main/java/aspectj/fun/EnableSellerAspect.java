package aspectj.fun;

import aspectj.Seller;
import aspectj.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by yjw on 18-9-18.
 */
@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "aspectj.NaiveWaiter", defaultImpl = SmartSeller.class)
    public static Seller seller;
}
