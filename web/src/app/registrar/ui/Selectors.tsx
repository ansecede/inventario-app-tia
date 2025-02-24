"use client";

import { Button } from "@/components/ui/button";
import Link from "next/link";

type Props = React.PropsWithChildren;
export default function Selectors({ children }: Props) {
    return (
        <>
            <Link href={"/registrar?type=producto"}>
                <Button>Registrar Producto</Button>
            </Link>
            <Link href={"/registrar?type=local"}>
                <Button>Registrar Local</Button>
            </Link>
        </>
    );
}
