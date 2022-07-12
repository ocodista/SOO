import { Grid } from '@chakra-ui/react'
import { NicheDetail, NicheDetailProps } from './NicheDetail'

type Niche = NicheDetailProps;

const mockNiche: Array<Niche> = [
  {
    temperature: 32,
    isLightOn: true,
    isWaterOn: false,
    moisture: 25,
    nicheId: 1
  },
  {
    temperature: 32,
    isLightOn: true,
    isWaterOn: false,
    moisture: 25,
    nicheId: 3
  },
  {
    temperature: 32,
    isLightOn: true,
    isWaterOn: false,
    moisture: 25,
    nicheId: 4
  }
]

export function NicheArea () {
  function orderNiche (niches: Array<NicheDetailProps>) {
    return niches.sort((a, b) => a.nicheId && b.nicheId ? a.nicheId - b.nicheId : 0)
  }

  function parseNicheList (niches: Array<NicheDetailProps>) {
    const newNicheList = new Array<NicheDetailProps>(9)

    niches.forEach((niche, index) => {
      if (niche.nicheId) {
        newNicheList[niche.nicheId - 1] = niche
      }
    })

    return newNicheList
  }

  const orderedNiche = parseNicheList(orderNiche(mockNiche))

  return (
    <Grid
      templateColumns="repeat(3, 1fr)"
      templateRows="repeat(3, 1fr)"
      gap="8px"
      height="100%"
    >
      {orderedNiche.map((niche, index) => {
        console.log('map niche ' + index, niche)
        if (niche) {
          return (
            <NicheDetail
            key={index}
            nicheId={niche.nicheId}
            isLightOn={niche.isLightOn}
            isWaterOn={niche.isWaterOn}
            moisture={niche.moisture}
            temperature={niche.temperature}
          />
          )
        }
        return (<NicheDetail key={index} isEmpty />)
      })}
    </Grid>
  )
}
