import request from '@/utils/request'

// 查询景区活动，存储景区活动列表
export function listEvent(query) {
  return request({
    url: '/system/event/list',
    method: 'get',
    params: query
  })
}

// 查询景区活动，存储景区活动详细
export function getEvent(eventId) {
  return request({
    url: '/system/event/' + eventId,
    method: 'get'
  })
}

// 新增景区活动，存储景区活动
export function addEvent(data) {
  return request({
    url: '/system/event',
    method: 'post',
    data: data
  })
}

// 修改景区活动，存储景区活动
export function updateEvent(data) {
  return request({
    url: '/system/event',
    method: 'put',
    data: data
  })
}

// 删除景区活动，存储景区活动
export function delEvent(eventId) {
  return request({
    url: '/system/event/' + eventId,
    method: 'delete'
  })
}
