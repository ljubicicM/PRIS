import { useState } from "react";
import { Textfield } from "../components/textFieldComponent/textfield";
import "./styles/savePages.css"
import { Button } from "../components/buttonComponent/Button";
import { TextareaComponent } from "../components/textareaComponent/textarea";

export const SaveArtistPage = () => {

    const [artistName, setartistName] = useState("");

    const [artistDescription1, setartistDescription1] = useState("");
    const [artistDescription2, setartistDescription2] = useState("");
    const [artistDescription3, setartistDescription3] = useState("");

    const saveartist = () => {
        console.log(artistDescription3);
    }

    return (
        <div className="save-pages-container-outer">
            <div className="save-pages-container">
                <h1>Save Artist</h1>
                <Textfield headerText="Artist Name" value={artistName} setValue={setartistName} placeholder="artist Name" />
                <TextareaComponent label="Artist Description 1" value={artistDescription1} onChange={(e: any) => setartistDescription1(e.target.value)} placeholder="Artist Description 1" />
                <TextareaComponent label="Artist Description 2" value={artistDescription2} onChange={(e: any) => setartistDescription2(e.target.value)} placeholder="Artist Description 2" />
                <TextareaComponent label="Artist Description 3" value={artistDescription3} onChange={(e: any) => setartistDescription3(e.target.value)} placeholder="Artist Description 3" />
                <Button label="Save Artist" size="medium" onClick={saveartist}
                    isEnabeld={artistName !== "" && artistDescription1 !== "" && artistDescription2 !== "" && artistDescription3 !== ""} />
            </div>
        </div>
    );
}