import React from 'react';
import '../../App.css';
import '../trailer.css';
import YouTube from "react-youtube";


export default function Trailer() {
    const videoOptions = {
        height: '983',
        width: '2133',
        playerVars: {
            autoplay: 1,
            controls: 1,
            rel: 0,
            showinfo: 0,
            mute: 0,
            loop: 1
        }
    };
    return (
        <div>
            <div className="player-wrapper">
                <YouTube videoId="aiGHMWduSo4" opts={videoOptions} />
            </div>
    </div>
    );
}