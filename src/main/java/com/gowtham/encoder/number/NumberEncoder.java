package com.gowtham.encoder.number;

import java.util.Collection;

import com.gowtham.encoder.dao.EncodedNumber;

public interface NumberEncoder{

    Collection<EncodedNumber> encode(String number);
}
