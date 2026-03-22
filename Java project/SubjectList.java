public class SubjectList {
    private SubjectNode head;

    public void insert(String code, String name) {
        SubjectNode n = new SubjectNode(code, name);
        n.next = head;
        head = n;
    }

    public void remove(String code) {
        SubjectNode current = head, prev = null;

        while (current != null) {
            if (current.code.equals(code)) {
                if (prev == null) head = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public String display() {
        String out = "";
        SubjectNode temp = head;
        while (temp != null) {
            out += temp.code + " - " + temp.name + "\n";
            temp = temp.next;
        }
        return out;
    }

    public String displayForFile() {
        String out = "";
        SubjectNode temp = head;
        while (temp != null) {
            out += temp.code + "," + temp.name + "\n";
            temp = temp.next;
        }
        return out;
    }

    public void clear() {
        head = null;
    }
}
