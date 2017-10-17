import React from 'react'
import { LineChart, Line, XAxis, YAxis, CartesianGrid } from 'recharts'
import R from 'ramda'

const data = [
  {
    abilityIndex: 165,
    attack: 0,
    createdAt: '17.10.2017',
    defence: 56,
    efficiency: 174,
    experience: 19,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 37,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 32,
  },
  {
    abilityIndex: 165,
    attack: 0,
    createdAt: '16.10.2017',
    defence: 56,
    efficiency: 174,
    experience: 19,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 37,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 32,
  },
  {
    abilityIndex: 164,
    attack: 0,
    createdAt: '15.10.2017',
    defence: 55,
    efficiency: 173,
    experience: 19,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 37,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 32,
  },
  {
    abilityIndex: 164,
    attack: 0,
    createdAt: '13.10.2017',
    defence: 55,
    efficiency: 173,
    experience: 19,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 37,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 31,
  },
  {
    abilityIndex: 163,
    attack: 0,
    createdAt: '12.10.2017',
    defence: 54,
    efficiency: 172,
    experience: 19,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 37,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 31,
  },
  {
    abilityIndex: 163,
    attack: 0,
    createdAt: '11.10.2017',
    defence: 54,
    efficiency: 172,
    experience: 18,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 37,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 31,
  },
  {
    abilityIndex: 162,
    attack: 0,
    createdAt: '09.10.2017',
    defence: 53,
    efficiency: 171,
    experience: 18,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 37,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 31,
  },
  {
    abilityIndex: 160,
    attack: 0,
    createdAt: '06.10.2017',
    defence: 52,
    efficiency: 169,
    experience: 18,
    form: 0,
    goalie: 0,
    growthPotential: 5850,
    passing: 36,
    selfControl: 20,
    shooting: 0,
    speed: 1,
    strength: 51,
    weeks: 30,
  },
]

const CustomLabel = props => {
  const { x, y, stroke, value } = props
  return (
    <text x={x} y={y} dy={-4} fill={stroke} fontSize={10} textAnchor="middle">
      {value}
    </text>
  )
}

const ChartContainer = () => (
  <div>
    <h1>Käppyrät</h1>
    <LineChart width={1024} height={600} data={R.sortBy(R.prop('createdAt'), data)}>
      <XAxis dataKey="createdAt" />
      <YAxis />
      <CartesianGrid strokeDasharray="3 3" />
      <Line
        type="monotone"
        dataKey="abilityIndex"
        label={<CustomLabel />}
        isAnimationActive={false}
      />
    </LineChart>
  </div>
)

export default ChartContainer
