package se.kmdev.tvepg.epg.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import se.kmdev.tvepg.epg.EPGData;
import se.kmdev.tvepg.epg.domain.EPGChannel;
import se.kmdev.tvepg.epg.domain.EPGEvent;

/**
 * TODO: Add null check when fetching at position etc.
 * Created by Kristoffer on 15-05-23.
 */
public class EPGDataImpl implements EPGData {

    private List<EPGChannel> channels = new ArrayList<>();
    private List<List<EPGEvent>> events = new ArrayList<>();

    public EPGDataImpl(Map<EPGChannel, List<EPGEvent>> data) {
        channels = new ArrayList<>(data.keySet());
        events = new ArrayList<>(data.values());
    }

    public EPGChannel getChannel(int position) {
        return channels.get(position);
    }

    public List<EPGEvent> getEvents(int channelPosition) {
        return events.get(channelPosition);
    }

    public EPGEvent getEvent(int channelPosition, int programPosition) {
        return events.get(channelPosition).get(programPosition);
    }

    public int getChannelCount() {
        return channels.size();
    }

    @Override
    public boolean hasData() {
        return !channels.isEmpty();
    }
}
