/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";
import { Checkbox } from "./CheckBox";

declare interface MultipleCheckboxProps {
  artPieces: any[];
  index: number;
  setArtPieces: any;
}

export const MultipleCheckbox = ({ artPieces, index, setArtPieces }: MultipleCheckboxProps) => {
  const [hasMovement, setHasMovement] = useState(false);
  const [hasAuthor, setHasAuthor] = useState(false);
  const [hasEvent, setHasEvent] = useState(false);
  useEffect(() => {
    const newArtPieces = [...artPieces];
    newArtPieces[index].hasMovement = hasMovement;
    newArtPieces[index].hasAuthor = hasAuthor;
    newArtPieces[index].hasEvent = hasEvent;
    setArtPieces(newArtPieces);
  }, [hasMovement, hasAuthor, hasEvent]);
  return (
    <div className="multiple-checkbox-container">
      <Checkbox name="movement" val={hasMovement} setValue={setHasMovement} label="Artistic movement" />
      <Checkbox name="author" val={hasAuthor} setValue={setHasAuthor} label="Author" />
      <Checkbox name="events" val={hasEvent} setValue={setHasEvent} label="Event" />
    </div>
  );
};