import { Flex, Grid, GridItem, Heading } from '@chakra-ui/react'
import { useCallback, useEffect, useState } from 'react'
import { useSelector } from 'react-redux'
import { DispositivoType, EstanteType } from '../../services/types'
import { AppState } from '../../store'
import { NicheDetail } from './NicheDetail'

export function NicheArea () {
  const { current } = useSelector(({ estante }: AppState) => estante)
  const [prateleiras, setPrateleiras] = useState<any[][]>([[]])
  useEffect(() => {
    if (current) {
      setPrateleiras(parseNicheList(current))
    }
  }, [current])

  const parseNicheList = useCallback((estante: EstanteType) => {
    const newEstante: any[][] = new Array(estante.qtdPrateleiras).fill(0).map(_ => new Array(estante.qtdNichosPorPrateleira).fill(null))

    estante.prateleiras.forEach((prateleira) => {
      prateleira.nichos.forEach((nicho) => {
        const x = prateleira.posicaoVertical
        const y = nicho.posicaoHorizontal

        if (nicho?.dispositivos?.length) {
          newEstante[x][y] = {
            id: nicho.id,
            dispositivos: [...nicho.dispositivos],
            plantas: [...nicho.plantas]
          }
        }
      })
    })
    return newEstante
  }, [])

  if (!current) {
    return null
  }

  return (
    <Grid
      templateColumns={`repeat(${current.qtdNichosPorPrateleira}, 1fr)`}
      templateRows={`repeat(${current.qtdPrateleiras}, 1fr)`}
      gap="8px"
      height="100%"
    >
      {prateleiras.map((prateleira) => prateleira.map((nicho?: { id: number, dispositivos: DispositivoType[]}) => (
        <>
        {nicho
          ? (
            <GridItem
              key={nicho.id}
              as={Flex}
              flexDirection="column"
              gap="0.5rem"
              borderRadius="0.5rem"
              bg="yellow.800"
              opacity="0.7"
              padding="1.5rem"
            >
              <NicheDetail
                nicheId={nicho.id}
                dispositivos={nicho.dispositivos}
              />
            </GridItem>
            )
          : (
            <GridItem
              as={Flex}
              flexDirection="column"
              alignItems="center"
              justifyContent="center"
              gap="1rem"
              borderRadius="1rem"
              border="2px solid"
              borderColor="yellow.800"
              opacity="0.7"
              padding="8px"
            >
              <Heading
                color="yellow.800"
              >Vazio</Heading>
            </GridItem>
            )}
        </>
      )))}
    </Grid>
  )
}
