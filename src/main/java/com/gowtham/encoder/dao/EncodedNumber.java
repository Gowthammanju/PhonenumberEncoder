package com.gowtham.encoder.dao;

public class EncodedNumber{

    private String number;
    private String encoded;

    public EncodedNumber(String number, String encodedNumber) {
        this.number = number;
        this.encoded = encodedNumber;
    }

    public String getEncodedNumber() {
        return encoded;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((encoded == null) ? 0 : encoded.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EncodedNumber other = (EncodedNumber) obj;
        if (encoded == null) {
            if (other.encoded != null)
                return false;
        } else if (!encoded.equals(other.encoded))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "number '" + number + "' encoded to '" + encoded + "'";
    }

}
