import { useState } from "react";
import { Button } from "../components/buttonComponent/Button";
import { Textfield } from "../components/textFieldComponent/textfield";
import { TextareaComponent } from "../components/textareaComponent/textarea";
import axios from "axios";
import { Dropdown } from "../components/dropdownComponent/dropdown";

export const SaveArtPiecePage = () => {
    const [artPieceName, setArtPieceName] = useState("");
    const [artPieceDescription1, setArtPieceDescription1] = useState("");
    const [artPieceAddress, setArtPieceAddress] = useState("");
    const [artPiecexCoord, setArtPiecexCoord] = useState("");
    const [artPieceyCoord, setArtPieceyCoord] = useState("");
    const [artPieceretentionTime, setArtPieceretentionTime] = useState("");
    const [artPieceYearCreated, setArtPieceYearCreated] = useState("");
    const [artPieceEpoch, setArtPieceEpoch] = useState(1);
    const [artPieceArtMov, setArtPieceArtMov] = useState(1);
    const [artPieceArtist, setArtPieceArtist] = useState(1);
    const [isInitialized, setIsInitialized] = useState(false);
    const [artMovements, setArtMovements] = useState([]);
    const [epochs, setEpochs] = useState([]);
    const [authors, setAuthors] = useState([]);

    const SaveArtPiece = () => {
        axios.post("http://localhost:8082/artPiece/saveArtPiece", {
            name: artPieceName,
            description: artPieceDescription1,
            address: artPieceAddress,
            xCoordinate: artPiecexCoord,
            yCoordinate: artPieceyCoord,
            retentionTime: artPieceretentionTime,
            yearCreated: artPieceYearCreated,
            idEpoch: artPieceEpoch,
            idArtisticMovement: artPieceArtMov,
            idAuthor: artPieceArtist,
            image: null
        }).then((response) => {
            console.log(response);

        }).catch((error) => {
            console.log(error);
        });
        setArtPieceName("");
        setArtPieceDescription1("");
        setArtPieceAddress("");
        setArtPiecexCoord("");
        setArtPieceyCoord("");
        setArtPieceretentionTime("");
        setArtPieceYearCreated("");
        setArtPieceEpoch(1);
        setArtPieceArtMov(1);
        setArtPieceArtist(1);
    };

    const loadArtisticMovement = async () => {
        const response = await axios.get('http://localhost:8082/artisticMovement/getAll');
        if (response.data) {
            setArtMovements(response.data.map((movement: any) => { return { id: movement.id, value: movement.movementName } }));
        }
        else {
            console.log('Error loading artistic movements');
        }
    }

    const loadEpochs = async () => {
        const response = await axios.get('http://localhost:8082/epoch/getAll');
        if (response.data) {
            setEpochs(response.data.map((epoch: any) => { return { id: epoch.id, value: epoch.epochName } }));
        }
        else {
            console.log('Error loading epochs');
        }
    }

    const loadAuthors = async () => {
        const response = await axios.get('http://localhost:8082/author/getAll');
        if (response.data) {
            setAuthors(response.data.map((author: any) => { return { id: author.id, value: author.nameAuthor } }));
        }
        else {
            console.log('Error loading authors');
        }
    }

    const loadContent = () => {
        loadArtisticMovement();
        loadEpochs();
        loadAuthors();
    }

    if (!isInitialized) {
        loadContent();
        setIsInitialized(true);
    }
    return (
        <div className="save-pages-container-outer">
            <div className="save-pages-container">
                <h1>Save Epoch</h1>
                <div className="save-artpiece-container">
                    <Textfield headerText="Art Piece Name" value={artPieceName} setValue={setArtPieceName} placeholder="Art Piece Name" />
                    <TextareaComponent label="Art Piece Description 1" value={artPieceDescription1} onChange={(e: any) => setArtPieceDescription1(e.target.value)} placeholder="Art Piece Description 1" />
                    <Textfield headerText="Art Piece Address" value={artPieceAddress} setValue={setArtPieceAddress} placeholder="Art Piece Address" />
                    <Textfield headerText="Art Piece x Coord" value={artPiecexCoord} setValue={setArtPiecexCoord} placeholder="Art Piece x Coord" />
                    <Textfield headerText="Art Piece y Coord" value={artPieceyCoord} setValue={setArtPieceyCoord} placeholder="Art Piece y Coord" />
                    <Textfield headerText="Art Piece Retention Time" value={artPieceretentionTime} setValue={setArtPieceretentionTime} placeholder="Art Piece Retention Time" />
                    <Textfield headerText="Art Piece Year Created" value={artPieceYearCreated} setValue={setArtPieceYearCreated} placeholder="Art Piece Year Created" />
                    <div className="save-artpiece-dropdowns">
                        <Dropdown headerText="Art Piece Epoch" value={artPieceEpoch} handleChange={setArtPieceEpoch} options={epochs} />
                        <Dropdown headerText="Art Piece Art Mov" value={artPieceArtMov} handleChange={setArtPieceArtMov} options={artMovements} />
                        <Dropdown headerText="Art Piece Artist" value={artPieceArtist} handleChange={setArtPieceArtist} options={authors} />
                    </div>
                </div>
                <Button label="Save Epoch" size="medium" onClick={SaveArtPiece}
                    isEnabeld={true} />
            </div>
        </div >
    );
}