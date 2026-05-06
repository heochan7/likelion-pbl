package package1;

public interface SubmitPolicy {
    boolean canSubmit();
}

class LionSubmitPolicy implements SubmitPolicy{
    @Override
    public boolean canSubmit() {
        return true;
    }
}

class StaffSubmitPolicy implements SubmitPolicy{
    @Override
    public boolean canSubmit() {
        return false;
    }
}