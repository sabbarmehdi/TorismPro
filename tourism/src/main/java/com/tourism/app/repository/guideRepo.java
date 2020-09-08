package com.tourism.app.repository;

import com.tourism.app.model.TripGuide;

import javax.transaction.Transactional;

@Transactional
public interface guideRepo extends TripListRepo<TripGuide>{
}
