/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume resumes) {
       if (size() < storage.length) {
           storage[size()] = resumes;
           size++;
       }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++){
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                if (storage[i+1] != null) {
                    for (int j = i; j < size() - 1; j++) {
                        storage[j] = storage[j + 1];
                    }
                    storage[size() - 1] = null;
                    size--;
                    break;
                }
                else {
                    size--;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            resumes[i] = storage[i];
        }
        return r;
    }

    int size() {
        return size;
    }
}
