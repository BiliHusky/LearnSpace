package r2;

import r4.UtilityClass;

/**
 * Created by yjw on 18-12-28.
 */
public class BuilderTest {
    private final int id;
    private final String name;
    private final String tel;
    private final String other;

    public static class Builder {
        private final int id;
        private String name = "";
        private String tel = "";
        private String other = "";

        public Builder(int id) {
            this.id = id;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder tel(String val) {
            tel = val;
            return this;
        }

        public Builder other(String val) {
            other = val;
            return this;
        }

        public BuilderTest build() {
            return new BuilderTest(this);
        }
    }

    private BuilderTest(Builder builder) {
        id = builder.id;
        name = builder.name;
        tel = builder.tel;
        other = builder.other;
    }

    public void printObj() {
        System.out.println(String.format("id:%d name:%s tel:%s other:%s", id, name, tel, other));
    }

    public static void main(String[] args) {
        BuilderTest t1 = new BuilderTest.Builder(1).name("test").tel("110").build();
        t1.printObj();

    }
}
