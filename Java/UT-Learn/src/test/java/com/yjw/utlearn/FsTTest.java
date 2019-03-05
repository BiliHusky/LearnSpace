package com.yjw.utlearn;

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;

import static org.powermock.api.support.membermodification.MemberMatcher.constructor;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

/**
 * Created by yjw on 19-2-25.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FsT.class)
public class FsTTest {
    @Test
    public void t() throws Exception {
        FsT t = new FsT();
        PowerMockito.verifyNew(FsTTest.class).withNoArguments();
        t.down();
    }
}
