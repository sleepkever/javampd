/*
 * MPDSong.java
 *
 * Created on September 27, 2005, 10:39 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package org.bff.javampd.objects;

/**
 * MPDSong represents a song in the MPD database that can be inserted into
 * a playlist.
 *
 * @author Bill
 * @version 1.0
 */
public class MPDSong extends MPDItem {

    private String title;
    private String artistName;
    private String albumName;
    private String file;
    private String genre;
    private String comment;
    private String year;
    private String discNumber;
    private int length;
    private int track;
    private int position = -1;
    private int id = -1;

    /**
     * Returns the name of the song.
     *
     * @return the name of the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the name of the song.
     *
     * @param title the name of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the name of the artist.
     *
     * @return the name of the artist
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * Sets the name of the artist.
     *
     * @param artistName the name of the artist
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * Returns the name of the album.
     *
     * @return the name of the album
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Sets the name of the album.
     *
     * @param albumName the name of the album
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    /**
     * Returns the path of the song without a leading or trailing slash.
     *
     * @return the path of the song
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the path of the song.
     * Any leading or trailing slashes will be removed.
     *
     * @param path the path of the song
     */
    public void setFile(String path) {
        this.file = path;
    }

    /**
     * Returns the length of the song in seconds.
     *
     * @return the length of the song
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the song.
     *
     * @param length the length of the song in seconds
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns the track number of the song.
     *
     * @return the track number
     */
    public int getTrack() {
        return track;
    }

    /**
     * Sets the track number of the song
     *
     * @param track the track number of the song
     */
    public void setTrack(int track) {
        this.track = track;
    }

    /**
     * Returns the genre of the song.
     *
     * @return the genre of the song
     */
    public String getGenre() {
        return genre != null ? genre : "No Genre";
    }

    /**
     * Sets the genre of the song
     *
     * @param genre the genre of the song
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the comment tag of the song.
     *
     * @return the comment tag of the song
     */
    public String getComment() {
        return comment != null ? comment : "";
    }

    /**
     * Sets the comment tag of the song
     *
     * @param comment the comment tag of the song
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the year of the song.
     *
     * @return the year of the song
     */
    public String getYear() {
        return year != null ? year : "No Year";
    }

    /**
     * Sets the year of the song
     *
     * @param year the year of the song
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Returns the string representation of this MPDSong.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "File:" + getFile() + "\n"
                + "Title:" + getTitle() + "\n"
                + "Artist:" + getArtistName() + "\n"
                + "Album:" + getAlbumName() + "\n"
                + "Track:" + getTrack() + "\n"
                + "Year:" + getYear() + "\n"
                + "Genre:" + getGenre() + "\n"
                + "Comment:" + getComment() + "\n"
                + "Length:" + getLength() + "\n"
                + "Pos:" + getPosition() + "\n"
                + "SongId:" + getId() + "\n";
    }

    /**
     * Returns the position of the song in the playlist. Returns
     * a -1 if the song is not in the playlist.
     *
     * @return the position in the playlist
     */
    public int getPosition() {
        return position;
    }

    /**
     * Returns the playlist song id for the song. Returns
     * a -1 if the song is not in the playlist.
     *
     * @return song id of the song
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the playlist position for a song.
     *
     * @param position the playlist position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Sets the playlist song id for this MPDSong.
     *
     * @param id the playlist song id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the discNumber
     */
    public String getDiscNumber() {
        return discNumber != null ? discNumber : "";
    }

    /**
     * @param discNumber the discNumber to set
     */
    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    /**
     * Compares this MPDSong to the specified object.  The result is true if and only
     * if the argument is not null and is a MPDSong that has the same file path.
     *
     * @param object the object to compare to
     * @return true if the paths are equal; false otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if ((object == null) || (object.getClass() != this.getClass())) {
            return false;
        }

        MPDSong song = (MPDSong) object;

        return this.getFile().equals(song.getFile());
    }

    @Override
    public String getName() {
        return getTitle();
    }

    /**
     * Returns the hash code for this object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + getLength();
        hash = 31 * hash + (null == getTitle() ? 0 : getTitle().hashCode());
        return hash;
    }

    @Override
    public int compareTo(MPDItem item) {
        MPDSong song = (MPDSong) item;
        StringBuilder sb;

        sb = new StringBuilder();
        sb.append(getAlbumName());
        sb.append(formatToComparableString(getTrack()));
        String thisSong = sb.toString();

        sb = new StringBuilder();
        sb.append(song.getAlbumName());
        sb.append(formatToComparableString(song.getTrack()));
        String songToCompare = sb.toString();

        return thisSong.compareTo(songToCompare);
    }

    private String formatToComparableString(int i) {
        return String.format("%1$08d", i);
    }
}
