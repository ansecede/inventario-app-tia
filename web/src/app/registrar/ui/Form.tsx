"use client";
import { Button } from "@/components/ui/button";
import { useEffect, useState, useActionState } from "react";
import ProductInputs from "./ProductInputs";
import { registerProduct } from "@/api/Product";
import SuccesAlert from "@/components/SuccesAlert";
import { FormType } from "@/lib/types";
import useSelectFormToRender from "../hooks/useSelectFormToRender";

export default function Form({ type }: { type: FormType }) {
    const { formAction, component } = useSelectFormToRender(type);
    const [state, action] = useActionState(formAction, undefined);
    const [_, setRerender] = useState(false);

    useEffect(() => {
        setTimeout(() => {
            if (state?.message) {
                state.message = "";
                setRerender((value) => !value);
            }
        }, 3000);
    }, [state]);
    return (
        <form
            action={action}
            className="w-full min-w-3xs px-10 flex gap-2 flex-col items-left py-16 rounded-2xl bg-black/20"
        >
            {component}
            <Button type="submit" className="w-1/2 py-6 mt-4 mb-4 text-lg">
                Añadir
            </Button>
            {state?.message ? (
                <SuccesAlert>{state.message}</SuccesAlert>
            ) : (
                <></>
            )}
        </form>
    );
}
