package com.telus.ds.test;

import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.apache.logging.log4j.core.util.Assert;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.telus.ds.TrackApplication;
import com.telus.ds.controller.TrackController;
import com.telus.ds.entity.Track;
import com.telus.ds.entity.dto.TrackDTO;
import com.telus.ds.repository.TrackRepository;
import com.telus.ds.service.TrackService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TrackApplication.class)
class TrackApplicationTests {

	@Autowired
	private TrackRepository trackRepository;

	@Autowired
	private TrackService trackService;

	@Autowired
	private TrackController trackController;

	@Test
	void getTrackController() {
		// with
		TrackService trackServiceMock = mock(TrackService.class);
		Track track = new Track("USVT10300001", 232106);

		// when
		Mockito.when(trackServiceMock.getTrack("USVT10300001")).thenReturn(track);
		TrackDTO resultTrackDTO = trackController.getTrack("USVT10300001");

		// then
		Assert.isNonEmpty(resultTrackDTO);
	}

	@Test
	void getTrackService() {
		// with
		TrackRepository trackRepositoryMock = mock(TrackRepository.class);
		Track track = new Track("USVT10300001", 232106);

		// when
		Mockito.when(trackRepositoryMock.findByIsrc("USVT10300001")).thenReturn(track);
		Track resultTrack = trackService.getTrack("USVT10300001");

		// then
		Assert.isNonEmpty(resultTrack);
	}

	@Test
	void saveTrackRepository() {
		// with
		Track track = new Track("USVT10300004", 232106);
		track.setCreationDate(LocalDateTime.now());

		// when
		trackRepository.save(track);
		Track resultTtrack = trackRepository.findByIsrc("USVT10300004");

		// then
		MatcherAssert.assertThat(resultTtrack.getDuration().longValue(), equalTo(232106L));

	}

	@Test
	void findByIsrcTrackRepository() {
		// with
		// insert data from data.sql

		// when
		Track resultTtrack = trackRepository.findByIsrc("USVT10300001");

		// then
		MatcherAssert.assertThat(resultTtrack.getIsrc(), equalTo("USVT10300001"));

	}
}
