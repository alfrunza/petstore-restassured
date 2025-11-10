package models;

//Even though the enum values are normally uppercase, they are defined this way to match the expected JSON values in the API.

/**
 * Enum representing the status of a pet.
 */
public enum Status {
    available,
    pending,
    sold
}
