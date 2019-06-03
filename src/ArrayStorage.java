/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (i < storage.length && storage[i] != null) {
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        int i = 0;
        while (i < storage.length && storage[i] != null) {
            i++;
        }
        if (i < storage.length) {
            storage[i] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++){
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                if (storage[i+1] != null) {
                    for (int j = i; j < storage.length - 1; j++) {
                        storage[j] = storage[j + 1];
                    }
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = size();
        Resume[] r = new Resume[size];
        for (int i = 0; i < size; i++) {
            r[i] = storage[i];
        }
        return r;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count++;
            }
        }
        return count;
    }
}
